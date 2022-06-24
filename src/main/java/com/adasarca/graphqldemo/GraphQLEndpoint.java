package com.adasarca.graphqldemo;

import com.adasarca.graphqldemo.dao.LinkDao;
import com.adasarca.graphqldemo.dao.UserDao;
import com.adasarca.graphqldemo.dao.VoteDao;
import com.adasarca.graphqldemo.graphql.*;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LinkDao linkDao = new LinkDao();
        UserDao userDao = new UserDao();
        VoteDao voteDao = new VoteDao();

        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(linkDao, userDao, voteDao),
                        new Mutation(linkDao, userDao, voteDao),
                        new LinkResolver(userDao),
                        new VoteResolver(userDao, linkDao))
                .scalars(Scalars.dateTime)
                .build()
                .makeExecutableSchema();
    }

    @Override
    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
                .collect(Collectors.toList());
    }
}
