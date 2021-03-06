package service;

import model.Comment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class CommentService implements ICommentService{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Comment> findAll() {
        Session session= sessionFactory.openSession();
        String queryStr = "SELECT c FROM Comment AS c";
        TypedQuery<Comment> query=session.createQuery(queryStr,Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(int id) {
        Session session= sessionFactory.openSession();
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id= :id";
        TypedQuery<Comment> query=session.createQuery(queryStr,Comment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        Session session=null;
        Transaction transaction=null;
        try {
            session= sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(comment);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        }finally {
            if (session !=null) session.close();
        }

    }

    @Override
    public void update(Comment comment) {
        Session session=null;
        Transaction transaction=null;
        try {
            session= sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.update(comment);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        }finally {
            if (session !=null) session.close();
        }

    }

    @Override
    public void delete(int id) {
        Session session= sessionFactory.openSession();
        String queryStr = "DELETE FROM Comment AS c WHERE c.id= :id";
        TypedQuery<Comment> query=session.createQuery(queryStr,Comment.class);
        query.setParameter("id",id);

    }
}
