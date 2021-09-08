package com.elina.SchoolSpringJavaNoSD2.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractJPARepository< T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findById(Long id ){
        return entityManager.find( clazz, id );
    }
    public List findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    @Transactional
    public void save( T entity ){
        entityManager.persist( entity );
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        entityManager.remove( entity );
    }
    public void deleteById( long entityId ){
        T entity = findById( entityId );
        delete( entity );
    }
}
