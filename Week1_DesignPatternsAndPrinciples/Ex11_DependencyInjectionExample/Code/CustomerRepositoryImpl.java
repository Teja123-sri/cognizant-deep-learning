package Week1_DesignPatternsAndPrinciples.Ex11_DependencyInjectionExample.Code;
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate a database fetch
        if (id == 101) {
            return "Customer [ID: 101, Name: John Doe]";
        } else if (id == 102) {
            return "Customer [ID: 102, Name: Jane Smith]";
        } else {
            return "Customer not found.";
        }
    }
}

