package Week1_DesignPatternsAndPrinciples.Ex11_DependencyInjectionExample.Code;
public class Main {
    public static void main(String[] args) {
        // Create the concrete repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject it into the service
        CustomerService service = new CustomerService(repository);

        // Test customer fetch
        service.getCustomerInfo(101);
        service.getCustomerInfo(102);
        service.getCustomerInfo(103);
    }
}
