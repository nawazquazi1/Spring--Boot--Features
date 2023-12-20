package com.nawaz.spring.boot.filter;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class ApplicationFilter implements Filter {

	Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Resource opened....");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		try {
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "cisco");
			Base.openTransaction();
			chain.doFilter(req, resp);
			Base.commitTransaction();
		} catch (IOException | ServletException e) {
			Base.rollbackTransaction();
			throw e;
		} finally {

			Base.close();
		}
		LOGGER.info("Processing took: {} milliseconds", System.currentTimeMillis() - before);

	}

	@Override
	public void destroy() {
		System.out.println("Resource closed....");

	}

}
