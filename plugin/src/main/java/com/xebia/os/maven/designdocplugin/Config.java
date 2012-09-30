/*
   Copyright 2012 Xebia Nederland B.V.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.xebia.os.maven.designdocplugin;

import java.util.Locale;

/**
 * Encapsulates the plugin configuration.
 *
 * @author Barend Garvelink <bgarvelink@xebia.com> (https://github.com/barend)
 */
class Config {

    public final ExistingDocs existingDocs;
    public final boolean createDbs;

    public Config(String existingDocs, boolean createDbs) {
        this.existingDocs = ExistingDocs.valueOf(existingDocs.toUpperCase(Locale.ROOT));
        this.createDbs = createDbs;
    }

    /**
     * Indicates how to handle an existing design document.
     */
    static enum ExistingDocs {

        /**
         * Keep the original, ignore the local document.
         */
        KEEP,

        /**
         * Delete the original, then upload the local document as new.
         */
        REPLACE,

        /**
         * Copy the existing document's {@code _rev} into the local document, then
         * upload the local document as a new version.
         */
        UPDATE,

        /**
         * Fail the build.
         */
        FAIL;
    }
}