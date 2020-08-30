package com.peterphi.std.guice.hibernate.webquery.impl.jpa;


@com.google.inject.Singleton
public class JPASearchExecutor {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchExecutor.class);

	@com.google.inject.Inject
	com.peterphi.std.guice.hibernate.module.logging.HibernateObservingInterceptor hibernateObserver;

	@com.google.inject.Inject
	org.hibernate.SessionFactory sessionFactory;

	public <T> com.peterphi.std.guice.hibernate.webquery.ConstrainedResultSet<T> find(final com.peterphi.std.guice.hibernate.webquery.impl.QEntity entity, final com.peterphi.std.guice.restclient.jaxb.webquery.WebQuery query, com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchStrategy strategy, java.util.function.Function<?, ?> serialiser) {
		final com.peterphi.std.guice.hibernate.module.logging.HibernateSQLLogger statementLog;
		if (query.isLogSQL())
			statementLog = hibernateObserver.startSQLLogger();
		else
			statementLog = null;

		try {
			com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPAQueryBuilder builder = new com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPAQueryBuilder(sessionFactory.getCurrentSession(), entity);
			builder.forWebQuery(query);
			if ((strategy == null) || (strategy == com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchStrategy.AUTO)) {
				if (org.apache.commons.lang.StringUtils.equals(query.getFetch(), "id")) {
					strategy = com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchStrategy.ENTITY_WRAPPED_ID;
				} else {
					if (((query.getLimit() > 0) || (query.getOffset() > 0)) && (builder.hasCollectionJoin() || builder.hasCollectionFetch())) {
						strategy = com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchStrategy.ID_THEN_QUERY_ENTITY;
					} else {
						strategy = com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPASearchStrategy.ENTITY;
					}
				}
			}
			java.lang.Long total = null;
			java.util.List list;
			switch (strategy) {
				case ID :
					{
						list = builder.selectIDs();
						if (query.isComputeSize())
							total = builder.selectCount();

						break;
					}
				case ENTITY_WRAPPED_ID :
					{
						list = builder.selectIDs();
						if (query.isComputeSize())
							total = builder.selectCount();

						list = ((java.util.List) (list.stream().map(entity::newInstanceWithId).collect(java.util.stream.Collectors.toList())));
						break;
					}
				case ENTITY :
					{
						if (query.isComputeSize())
							total = builder.selectCount();

						list = builder.selectEntity();
						break;
					}
				case ID_THEN_QUERY_ENTITY :
					{
						list = builder.selectIDs();
						if (query.isComputeSize())
							total = builder.selectCount();

						builder = new com.peterphi.std.guice.hibernate.webquery.impl.jpa.JPAQueryBuilder(sessionFactory.getCurrentSession(), entity);
						builder.forIDs(query, list);
						if (!list.isEmpty())
							list = builder.selectEntity();

						break;
					}
				default :
					throw new com.peterphi.std.NotImplementedException(("Search Strategy " + strategy) + " not yet implemented");
			}
			if (serialiser != null)
				list = ((java.util.List) (list.stream().map(serialiser).collect(java.util.stream.Collectors.toList())));

			com.peterphi.std.guice.hibernate.webquery.ConstrainedResultSet resultset = new com.peterphi.std.guice.hibernate.webquery.ConstrainedResultSet(query, list);
			if (statementLog != null)
				resultset.setSql(statementLog.getAllStatements());

			if (total != null)
				resultset.setTotal(total);

			return ((com.peterphi.std.guice.hibernate.webquery.ConstrainedResultSet<T>) (resultset));
		} finally {
			statementLog.close();
		}
	}
}

