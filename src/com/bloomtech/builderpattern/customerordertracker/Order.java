package com.bloomtech.builderpattern.customerordertracker;

import java.time.LocalDate;

public class Order {
    // Define data members
    private Item item; //required
    private String customername; //required
    private String shippingaddress; //required

    private String customeremail;
    private String customerphone;
    private String affiliatecode;

    private String billingaddress; //defaults to shipping address
    private int quantity; //defaults to 1

    private LocalDate orderplaced; //auto-generated

    public static OrderBuilder builder() {return  new OrderBuilder();}


    private Order(OrderBuilder builder) {
        this.item = builder.item;
        this.customername = builder.customername;
        this.shippingaddress = builder.shippingaddress;
        this.billingaddress = builder.billingaddress;

        this.customeremail = builder.customeremail;
        this.customerphone = builder.customerphone;

        this.quantity = builder.quantity;
        this.affiliatecode = builder.affiliatecode;
        this.orderplaced = builder.orderplaced;
    }

    public static class OrderBuilder {
        private Item item; //required
        private String customername; //required
        private String shippingaddress; //required
        private String customeremail;
        private String customerphone;
        private String affiliatecode;
        private String billingaddress; //defaults to shipping address
        private int quantity; //defaults to 1
        private LocalDate orderplaced; //auto-generated

        public OrderBuilder() {
            this.quantity = 1;
            this.orderplaced = LocalDate.now();

        }
        public OrderBuilder withItem(Item itemToUse) {
            this.item = itemToUse;
            return this;
        }
        public OrderBuilder withCustomerName(String customerNameToUse) {
            this.customername = customerNameToUse;
            return this;
        }
        public OrderBuilder withShippingAddress(String shippingAddressToUse) {
            this.shippingaddress = shippingAddressToUse;
            return this;
        }
        public OrderBuilder withCustomerEmail(String customerEmailToUse) {
            this.customeremail = customerEmailToUse;
            return this;
        }
        public OrderBuilder withCustomerPhone(String customerPhoneToUse) {
            this.customerphone = customerPhoneToUse;
            return this;
        }
        public OrderBuilder withAffiliateCode(String affiliateCodeToUse) {
            this.affiliatecode = affiliateCodeToUse;
            return this;
        }
        public OrderBuilder withBillingAddress(String billingAddressToUse) {
            this.billingaddress = billingAddressToUse;
            return this;
        }
        public OrderBuilder withQuantity(int quantityToUse) {
            this.quantity = quantityToUse;
            return this;
        }
        public Order build() {
            if (item == null) {
                throw new RuntimeException("Order item cannot be null");
            }
            if (customername == null) {
                throw new RuntimeException("Customer name cannot be null");
            }if (shippingaddress == null) {
                throw new RuntimeException("Shipping address cannot be null");
            }
            if (billingaddress == null) {
                billingaddress = shippingaddress;
            }
            return new Order(this);
        }
    }

    //Getters
    public Item getItem() {
        return item;
    }

    public String getCustomername() {
        return customername;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public String getAffiliatecode() {
        return affiliatecode;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderplaced() {
        return orderplaced;
    }

}
