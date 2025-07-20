package in.piyush.invoicegeneratorapi.controller;

import in.piyush.invoicegeneratorapi.entity.Invoice;
import in.piyush.invoicegeneratorapi.service.EmailService;
import in.piyush.invoicegeneratorapi.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
@CrossOrigin("*")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice){
        return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> fetchInvoices(){
        return ResponseEntity.ok(invoiceService.fetchInvoices());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeInvoice(@PathVariable String id){
        invoiceService.removeInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/sendinvoice")
    public ResponseEntity<?> sendInvoice(@RequestPart("file")MultipartFile file,
                                         @RequestPart("email")String customerEmail){
        try{
            emailService.sendInvoiceEmail(customerEmail,file);
            return ResponseEntity.ok().body("Invoice sent successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send invoice");
        }

    }
}
