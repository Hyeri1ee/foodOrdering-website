package marketcurly.marketcurlycopybakcend.service;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ShoppingBagRepository;
import marketcurly.marketcurlycopybakcend.service.serviceInterface.ShoppingBagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShoppingBagServiceImpl implements ShoppingBagService {
  private final ShoppingBagRepository shoppingBagRepository;
  @Override
  public void save(ShoppingBag.shoppingbagRequest request) {
    shoppingBagRepository.save(request.toEntity());//item crud must be ready for the test
  }

  @Override
  public ShoppingBag getShoppingBag(String loginId) {
    ShoppingBag userShoppingBag = shoppingBagRepository.findByUser(loginId);
    return userShoppingBag;
  }

  @Override
  public void deleteShoppingBag(String loginId) {
    Long id = shoppingBagRepository.findByUser(loginId).getUser().getId();
    shoppingBagRepository.deleteById(id);
  }


}
