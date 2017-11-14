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
package com.etlsolutions.examples.utility;

import com.etlsolutions.examples.data.general.Constrainable;
import com.google.common.base.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ConstrainableUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ConstrainableUtilitiesTest {

    private final Constrainable constrainable1 = new MockConstrainable("valueaaaa", "valuebbbb");
    private final Constrainable constrainable2 = new MockConstrainable("valueaaaa", "valuebbbb");
    private final Constrainable constrainable3 = new MockConstrainable("galueaaaa", "galuebbbb");

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(ConstrainableUtilities.hasSameConstraint(constrainable1, constrainable1));
        assertTrue(ConstrainableUtilities.hasSameConstraint(constrainable1, constrainable2));

        assertFalse(ConstrainableUtilities.hasSameConstraint(constrainable1, constrainable3));
        assertFalse(ConstrainableUtilities.hasSameConstraint(null, constrainable3));
        assertFalse(ConstrainableUtilities.hasSameConstraint(constrainable1, null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(ConstrainableUtilities.hasSameParameters(constrainable1, constrainable1));
        assertTrue(ConstrainableUtilities.hasSameParameters(constrainable1, constrainable2));

        assertFalse(ConstrainableUtilities.hasSameParameters(constrainable1, constrainable3));
        assertFalse(ConstrainableUtilities.hasSameParameters(null, constrainable3));
        assertFalse(ConstrainableUtilities.hasSameParameters(constrainable1, null));
    }

    private static final class MockConstrainable implements Constrainable<MockConstrainable> {

        private final String value1;
        private final String value2;

        public MockConstrainable(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public boolean hasSameConstraint(MockConstrainable constraintable) {
            return constraintable != null && Objects.equal(value1, constraintable.value1);
        }

        @Override
        public boolean hasSameParameters(MockConstrainable constraintable) {
            return hasSameConstraint(constraintable) && Objects.equal(value2, constraintable.value2);
        }
    }
}
