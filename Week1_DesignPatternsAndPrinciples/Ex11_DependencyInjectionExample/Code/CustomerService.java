package Week1_DesignPatternsAndPrinciples.Ex11_DependencyInjectionExample.Code;
public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerInfo(int id) {
        String result = customerRepository.findCustomerById(id);
        System.out.println(result);
    }
}
