package in.piyush.invoicegeneratorapi.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "invoices")
public class invoice {

    @Id
    private String id;
    private Company company;
    private Billing billing;
    private Shipping shipping;
    private InvoiceDetails invoice;
    private List<Item> items;
    private String notes;
    private String logo;
    private double tax;
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastUpdatedAt;
    private String thumbnailUrl;
    private String template;
    private String title;

    @Data
    public static class Company{
        public String name;
        public String address;
        public String phone;
    }

    @Data
    public static class Billing{
        public String name;
        public String phone;
        public String address;
    }

    @Data
    public static class Shipping{
        public String name;
        public String address;
        public String phone;
    }

    @Data
    public static class InvoiceDetails{
       public String number;
       public String date;
       public String dueDate;
    }

    public static class Item{
        public String name;
        public int qnt;
        public double amount;
        public String description;
    }
}
