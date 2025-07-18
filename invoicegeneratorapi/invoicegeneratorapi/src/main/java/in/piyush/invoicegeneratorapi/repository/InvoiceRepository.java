package in.piyush.invoicegeneratorapi.repository;

import in.piyush.invoicegeneratorapi.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice,String>{
}
