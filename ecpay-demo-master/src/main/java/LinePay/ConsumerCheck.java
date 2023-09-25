package LinePay;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumerCheck {
	public static String encrypt(final String keys, final String data) {
		return toBase64String(HmacUtils.getHmacSha256(keys.getBytes()).doFinal(data.getBytes()));
	}

	public static String toBase64String(byte[] bytes) {
		byte[] byteArray = Base64.encodeBase64(bytes);
		return new String(byteArray);
	}

	public static void main(String[] args) {
		// Request API
		CheckoutPaymentRequestForm form = new CheckoutPaymentRequestForm();
		form.setAmount(new BigDecimal("100"));
		form.setCurrency("TWD");
		form.setOrderId("merchant_order_id");

		ProductPackageForm productPackageForm = new ProductPackageForm();
		productPackageForm.setId("package_id");
		productPackageForm.setName("shop_name");
		productPackageForm.setAmount(new BigDecimal("100"));

		ProductForm productForm = new ProductForm();
		productForm.setId("product_id");
		productForm.setName("product_name");
		productForm.setImageUrl("");
		productForm.setQuantity(new BigDecimal("10"));
		productForm.setPrice(new BigDecimal("10"));
		productPackageForm.setProducts(Arrays.asList(productForm));

		form.setPackages(Arrays.asList(productPackageForm));
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setConfirmUrl("https://sandbox-api-pay.line.me/v2/payments/{transactionId}/confirm");
		redirectUrls.setCancelUrl("");
		form.setRedirectUrls(redirectUrls);
		String requestUri = "/v3/payments/request";
		String nonce = UUID.randomUUID().toString();

		// Confirm API
		ConfirmData confirmData = new ConfirmData();
		confirmData.setAmount(new BigDecimal("100"));
		confirmData.setCurrency("TMD");
		String confirmNonce = UUID.randomUUID().toString();
		String confirmUri = "/v3/payments/{transactionId}/confirm";
		// Capture API
		CaptureData captureData = new CaptureData();
		captureData.setAmount(new BigDecimal("100"));
		captureData.setCurrency("TMD");
		String captureNonce = UUID.randomUUID().toString();
		String captureUri = "/v3/payments/authorizations/{transactionId}/capture";
		// Check Payment API
		String checkNonce = UUID.randomUUID().toString();
		String checkUri = "/v3/payments/requests/{transactionId}/check";

		// Request API Confirm API 共用部分
		ObjectMapper mapper = new ObjectMapper();
		String ChannelSecret = "a917ab6a2367b536f8e5a6e2977e06f4";
		try {

			// Request API
			System.out.println("body =>" + mapper.writeValueAsString(form));
			System.out.println("nonce =>" + nonce);
			String signature = encrypt(ChannelSecret,
					ChannelSecret + requestUri + mapper.writeValueAsString(form) + nonce);
			System.out.println("signature =>" + signature);
			// Confirm API
			System.out.println("bodyConfirm =>" + mapper.writeValueAsString(confirmData));
			System.out.println("nonceConfirm =>" + confirmNonce);
			String signatureConfirm = encrypt(ChannelSecret,
					ChannelSecret + confirmUri + mapper.writeValueAsString(confirmData) + confirmNonce);
			System.out.println("signatureConfirm =>" + signatureConfirm);
			// Capture API
			System.out.println("bodyCapture =>" + mapper.writeValueAsString(captureData));
			System.out.println("nonceCapture =>" + captureNonce);
			String signatureCapture = encrypt(ChannelSecret,
					ChannelSecret + captureUri + mapper.writeValueAsString(captureData) + captureNonce);
			System.out.println("signatureCapture =>" + signatureCapture);
			// Check API
			System.out.println("nonceCheck =>" + checkNonce);
			String signatureCheck = encrypt(ChannelSecret, ChannelSecret + checkUri + checkNonce);
			System.out.println("signatureCheck =>" + signatureCheck);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
