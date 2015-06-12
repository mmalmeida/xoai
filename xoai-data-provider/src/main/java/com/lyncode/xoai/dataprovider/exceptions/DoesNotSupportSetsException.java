/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     client://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.xoai.dataprovider.exceptions;

/**
 * @author Development @ Lyncode
 * @version 3.1.0
 */
public class DoesNotSupportSetsException extends HandlerException {

    /**
     *
     */
    private static final long serialVersionUID = -7008970964208110045L;

    /**
     * Creates a new instance of <code>DoesNotSupportSetsException</code>
     * without detail message.
     */
    public DoesNotSupportSetsException() {
    }

    /**
     * Constructs an instance of <code>DoesNotSupportSetsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DoesNotSupportSetsException(String msg) {
        super(msg);
    }
}
