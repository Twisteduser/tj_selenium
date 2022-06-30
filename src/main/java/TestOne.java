import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;
import com.taxjar.model.taxes.TaxResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestOne {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("apiUrl", Taxjar.SANDBOX_API_URL);

        Taxjar client = new Taxjar("19fb9e843fb970c9d0e016a66312dae1", params);
        try {
            Map<String, Object> params2 = new HashMap<>();
            params2.put("from_country", "US");
            params2.put("from_zip", "53202");
            params2.put("from_state", "WI");
            params2.put("from_city", "Milwaukee");
            params2.put("from_street", "9500 Gilman Drive");
            params2.put("to_country", "US");
            params2.put("to_zip", "54304");
            params2.put("to_state", "WI");
            params2.put("to_city", "Green bay");
            params2.put("to_street", "1335 E 103rd St");
            params2.put("amount", 16.8);
            params2.put("shipping", 0);

//            List<Map> nexusAddresses = new ArrayList();
//            Map<String, Object> nexusAddress = new HashMap<>();
//            nexusAddress.put("country", "US");
//            nexusAddress.put("zip", "92093");
//            nexusAddress.put("state", "CA");
//            nexusAddress.put("city", "La Jolla");
//            nexusAddress.put("street", "9500 Gilman Drive");
//            nexusAddresses.add(nexusAddress);

            List<Map> lineItems = new ArrayList();
            Map<String, Object> lineItem = new HashMap<>();
            lineItem.put("id", 1);
            lineItem.put("quantity", 1);
            lineItem.put("product_tax_code", "20010");
            lineItem.put("unit_price", 16.8);
            lineItem.put("discount", 0);
            lineItems.add(lineItem);

//            params.put("nexus_addresses", nexusAddresses);
            params.put("line_items", lineItems);

            TaxResponse res = client.taxForOrder(params2);
//            Float VAT = res.tax.getAmountToCollect();
//            Float GrandTotal= (Float) params2.get("amount");
            System.out.println("VAT: " + res.tax.getAmountToCollect());
//            System.out.println(VAT+GrandTotal);
        } catch (TaxjarException e) {
            e.printStackTrace();
        }

    }
}
