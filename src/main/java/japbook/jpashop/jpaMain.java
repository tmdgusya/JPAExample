package japbook.jpashop;

import japbook.jpashop.domain.Member;
import japbook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction ts = entityManager.getTransaction();

        ts.begin();
        try{
            Order order = entityManager.find(Order.class, 1L);
            Long memberId = order.getMemberId();
            Member member = order.getMember();
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            entityManager.close();
        }
        emf.close();
    }
}
