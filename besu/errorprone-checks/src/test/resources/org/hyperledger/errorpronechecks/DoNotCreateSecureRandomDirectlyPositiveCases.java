/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.hyperledger.errorpronechecks;

import java.security.Provider;
import java.security.SecureRandom;

public class DoNotCreateSecureRandomDirectlyPositiveCases {

  public void callsSecureRandomGetInstance() throws Exception {
    // BUG: Diagnostic contains:  Do not create SecureRandom directly.
    SecureRandom.getInstance("");

    // BUG: Diagnostic contains:  Do not create SecureRandom directly.
    SecureRandom.getInstance("", "");

    // BUG: Diagnostic contains:  Do not create SecureRandom directly.
    SecureRandom.getInstance("", new Provider("", 0, "") {});
  }

  public void invokesSecureRandomConstructor() throws Exception {
    // BUG: Diagnostic contains:  Do not create SecureRandom directly.
    new SecureRandom();

    // BUG: Diagnostic contains:  Do not create SecureRandom directly.
    new SecureRandom(new byte[] {});
  }
}
