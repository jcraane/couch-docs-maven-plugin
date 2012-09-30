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

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import com.google.common.base.Preconditions;

/**
 * Implements handling of JSON for documents obtained from CouchDB.
 *
 * @author Barend Garvelink <bgarvelink@xebia.com> (https://github.com/barend)
 */
class RemoteDesignDocument extends DesignDocument {

    public RemoteDesignDocument(byte[] data) throws IOException, DocumentValidationException {
        Preconditions.checkNotNull(data, "data argument cannot be null");
        final JsonParser parser = getJsonFactory().createJsonParser(data);
        initRootNode(parser);
    }

    @Override
    public String toString() {
        return "RemoteDesignDocument[ " + getId() + " ]";
    }
}
