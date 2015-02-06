package ar.com.nutribot.core.util;


import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Utilizado desde los mapeos de hibernate para las clases que tienen un UUID
 * cómo ID.
 * 
 * @author lfishkel
 */
public class UUIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return UUID.randomUUID().toString();
	}
}

