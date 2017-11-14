/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Tests of class CustomerPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public final class CustomerPojoTest {

    private final int id = 2312031;
    private final int id1 = 36549;
    private final PersonAddressLinkPojo personAddressLink = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLink2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final String username = "usnamel99d";
    private final String username3 = "oqreoj31gg";
    private final String password = "lq43q42l1k3l**3";
    private final String password4 = "^(£*lasldfj";
    private final byte[] image = new byte[]{66, 97, 32, 92};
    private final byte[] image5 = new byte[]{5, 7, 82, 11};
    private final VoucherPojo voucherPojo1 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo2 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo3 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo4 = Mockito.mock(VoucherPojo.class);
    private final Set<Voucher> vouchers = new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3));
    private final Set<Voucher> vouchers6 = new HashSet<>(Arrays.asList(voucherPojo2, voucherPojo4));
    private final Set<Voucher> vouchers7 = null;
    private final InvoicePojo invoicePojo1 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo2 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo3 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo4 = Mockito.mock(InvoicePojo.class);
    private final Set<Invoice> invoices = new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3));
    private final Set<Invoice> invoices8 = new HashSet<>(Arrays.asList(invoicePojo2, invoicePojo4));
    private final Set<Invoice> invoices9 = null;
    private final WishlistPojo wishlistPojo1 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo2 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo3 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo4 = Mockito.mock(WishlistPojo.class);
    private final Set<Wishlist> wishlists = new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3));
    private final Set<Wishlist> wishlists10 = new HashSet<>(Arrays.asList(wishlistPojo4, wishlistPojo2));
    private final Set<Wishlist> wishlists11 = null;
    private final ShoppingCartItemPojo shoppingCartItemPojo1 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo2 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo3 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo4 = Mockito.mock(ShoppingCartItemPojo.class);
    private final Set<ShoppingCartItem> shoppingCart = new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3));
    private final Set<ShoppingCartItem> shoppingCart12 = new HashSet<>(Arrays.asList(shoppingCartItemPojo2, shoppingCartItemPojo4, shoppingCartItemPojo3));
    private final Set<ShoppingCartItem> shoppingCart13 = null;
    private final Customer customer = Mockito.mock(Customer.class);

    private final CustomerPojo instance = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance00 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance01 = new CustomerPojo(id1, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance02 = new CustomerPojo(id, personAddressLink2, username, password, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance03 = new CustomerPojo(id, personAddressLink, username3, password, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance04 = new CustomerPojo(id, personAddressLink, username, password4, image, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance05 = new CustomerPojo(id, personAddressLink, username, password, image5, vouchers, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance06 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers6, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance07 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers7, invoices, wishlists, shoppingCart);
    private final CustomerPojo instance08 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices8, wishlists, shoppingCart);
    private final CustomerPojo instance09 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices9, wishlists, shoppingCart);
    private final CustomerPojo instance10 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists10, shoppingCart);
    private final CustomerPojo instance11 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists11, shoppingCart);
    private final CustomerPojo instance12 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart12);
    private final CustomerPojo instance13 = new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart13);
    private final CustomerPojo instance14 = new CustomerPojo();
    private final CustomerPojo instance15 = new CustomerPojo(personAddressLink, username, password, image);
    private final CustomerPojo instance16 = new CustomerPojo(id, personAddressLink, username, password);
    private final CustomerPojo instance17 = new CustomerPojo(id, personAddressLink, username, password, image);
    private final CustomerPojo instance18 = new HibernateProxyCustomerPojo(new CustomerPojo(id, personAddressLink, username, password, image, vouchers, invoices, wishlists, shoppingCart));
    private final CustomerPojo instance19 = new CustomerPojo(id, new PersonAddressLinkPojo(), username, password, image, vouchers, invoices, wishlists, shoppingCart);

    @Before
    public void setUp() {

        Mockito.when(customer.getImage()).thenReturn(new byte[]{66, 97, 32, 92});
        Mockito.when(customer.getPassword()).thenReturn("lq43q42l1k3l**3");
        Mockito.when(customer.getPersonAddressLink()).thenReturn(personAddressLink);
        Mockito.when(customer.getUsername()).thenReturn("usnamel99d");
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(2312031, instance.getId());
        assertEquals(0, instance14.getId());
        assertEquals(0, instance15.getId());
        assertEquals(2312031, instance16.getId());
        assertEquals(2312031, instance17.getId());
        assertEquals(0, instance18.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(65432);
        assertEquals(65432, instance.getId());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLink, instance.getPersonAddressLink());
        assertNull(instance14.getPersonAddressLink());
        assertEquals(personAddressLink, instance15.getPersonAddressLink());
        assertEquals(personAddressLink, instance16.getPersonAddressLink());
        assertEquals(personAddressLink, instance17.getPersonAddressLink());
        assertNull(instance18.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {
        PersonAddressLinkPojo personAddressLinkK = Mockito.mock(PersonAddressLinkPojo.class);
        instance.setPersonAddressLink(personAddressLinkK);
        assertEquals(personAddressLinkK, instance.getPersonAddressLink());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetUsername() {

        assertEquals("usnamel99d", instance.getUsername());
        assertNull(instance14.getUsername());
        assertEquals("usnamel99d", instance15.getUsername());
        assertEquals("usnamel99d", instance16.getUsername());
        assertEquals("usnamel99d", instance17.getUsername());
        assertNull(instance18.getUsername());
    }

    /**
     * Test of setUsername method.
     */
    @Test
    public void testSetUsername() {

        instance.setUsername("adiejlkasdi");
        assertEquals("adiejlkasdi", instance.getUsername());
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals("lq43q42l1k3l**3", instance.getPassword());
        assertNull(instance14.getPassword());
        assertEquals("lq43q42l1k3l**3", instance15.getPassword());
        assertEquals("lq43q42l1k3l**3", instance16.getPassword());
        assertEquals("lq43q42l1k3l**3", instance17.getPassword());
        assertNull(instance18.getPassword());
    }

    /**
     * Test of setPassword method.
     */
    @Test
    public void testSetPassword() {

        instance.setPassword("adlfinnkdkdll2");
        assertEquals("adlfinnkdkdll2", instance.getPassword());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{66, 97, 32, 92}, instance.getImage());
        instance.getImage()[0] = 22;
        assertArrayEquals(new byte[]{66, 97, 32, 92}, instance.getImage());
        image[1] = 44;
        assertArrayEquals(new byte[]{66, 97, 32, 92}, instance.getImage());

        assertNull(instance14.getImage());
        assertArrayEquals(new byte[]{66, 97, 32, 92}, instance15.getImage());
        assertNull(instance16.getImage());
        assertArrayEquals(new byte[]{66, 97, 32, 92}, instance17.getImage());
        assertNull(instance18.getImage());
    }

    /**
     * Test of setImage method.
     */
    @Test
    public void testSetImage() {

        byte[] imageK = {82, 72, 91};
        instance.setImage(imageK);
        assertArrayEquals(new byte[]{82, 72, 91}, instance.getImage());
        imageK[1] = 0;
        assertArrayEquals(new byte[]{82, 72, 91}, instance.getImage());
    }

    /**
     * Test of getVouchers method.
     */
    @Test
    public void testGetVouchers() {

        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());
        instance.getVouchers().clear();
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());
        vouchers.clear();
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());

        assertNull(instance07.getVouchers());
        assertTrue(instance14.getVouchers().isEmpty());
        assertTrue(instance15.getVouchers().isEmpty());
        assertTrue(instance16.getVouchers().isEmpty());
        assertTrue(instance17.getVouchers().isEmpty());
        assertTrue(instance18.getVouchers().isEmpty());
    }

    /**
     * Test of setVouchers method.
     */
    @Test
    public void testSetVouchers() {

        Set<Voucher> vouchersK = new HashSet<>(Arrays.asList(voucherPojo4, voucherPojo3));
        instance.setVouchers(vouchersK);
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo4, voucherPojo3)), instance.getVouchers());
        vouchersK.clear();
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo4, voucherPojo3)), instance.getVouchers());

        instance.setVouchers(null);
        assertNull(instance.getVouchers());
    }

    /**
     * Test of getInvoices method.
     */
    @Test
    public void testGetInvoices() {

        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());
        instance.getInvoices().clear();
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());
        invoices.clear();
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());

        assertNull(instance09.getInvoices());
        assertTrue(instance14.getInvoices().isEmpty());
        assertTrue(instance15.getInvoices().isEmpty());
        assertTrue(instance16.getInvoices().isEmpty());
        assertTrue(instance17.getInvoices().isEmpty());
        assertTrue(instance18.getInvoices().isEmpty());
    }

    /**
     * Test of setInvoices method.
     */
    @Test
    public void testSetInvoices() {

        Set<Invoice> invoicesK = new HashSet<>(Arrays.asList(invoicePojo3));
        instance.setInvoices(invoicesK);
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo3)), instance.getInvoices());
        invoicesK.add(invoicePojo1);
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo3)), instance.getInvoices());

        instance.setInvoices(null);
        assertNull(instance.getInvoices());
    }

    /**
     * Test of getWishlists method.
     */
    @Test
    public void testGetWishlists() {

        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());
        instance.getWishlists().clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());
        wishlists.clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());

        assertNull(instance11.getWishlists());
        assertTrue(instance14.getWishlists().isEmpty());
        assertTrue(instance15.getWishlists().isEmpty());
        assertTrue(instance16.getWishlists().isEmpty());
        assertTrue(instance17.getWishlists().isEmpty());
        assertTrue(instance18.getWishlists().isEmpty());
    }

    /**
     * Test of setWishlists method.
     */
    @Test
    public void testSetWishlists() {

        Set<Wishlist> wishlistsK = new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo3));

        instance.setWishlists(wishlistsK);
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo3)), instance.getWishlists());
        wishlistsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo3)), instance.getWishlists());

        instance.setWishlists(null);
        assertNull(instance.getWishlists());
    }

    /**
     * Test of getShoppingCart method.
     */
    @Test
    public void testGetShoppingCart() {

        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        instance.getShoppingCart().clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        shoppingCart.clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());

        assertNull(instance13.getShoppingCart());
        assertTrue(instance14.getShoppingCart().isEmpty());
        assertTrue(instance15.getShoppingCart().isEmpty());
        assertTrue(instance16.getShoppingCart().isEmpty());
        assertTrue(instance17.getShoppingCart().isEmpty());
        assertTrue(instance18.getShoppingCart().isEmpty());
    }

    /**
     * Test of setShoppingCart method.
     */
    @Test
    public void testSetShoppingCart() {

        Set<ShoppingCartItem> shoppingCartU = new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2));

        instance.setShoppingCart(shoppingCartU);
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2)), instance.getShoppingCart());
        shoppingCartU.clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2)), instance.getShoppingCart());

        instance.setShoppingCart(null);        
        assertNull(instance.getShoppingCart());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance08));
        assertTrue(instance.equals(instance10));
        assertTrue(instance.equals(instance12));
        assertTrue(instance.equals(instance18));
        assertTrue(instance18.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(customer));
        assertFalse(instance.equals(instance01));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(customer));
        assertTrue(instance.hasSameConstraint(instance18));
        assertTrue(instance18.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance.hasSameParameters(instance18));
        assertTrue(instance18.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(customer));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));

    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("CustomerPojo{id=2312031, username=usnamel99d}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance19));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyCustomerPojo extends CustomerPojo implements HibernateProxy {

        private static final long serialVersionUID = 254629263818196859L;

        private final CustomerPojo pojo;

        public HibernateProxyCustomerPojo(CustomerPojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public CustomerPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
