package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Order;
import web.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

  private final OrderRepository repo;

  public List<Order> findAllOrders() {
    return repo.findAll();
  }

  public Order findOrderById(Long id) {
    return repo.findById(id).get();
  }

  public void addOrder(Order order) {
    repo.save(order);
  }

  public void deleteOrder(Order order) {
    repo.delete(order);
  }

  public List<Order> allUsersOrdersById(Long userId) {
    List<Order> all = repo.findAllByUser_id(userId);
    return all;
  }

}
