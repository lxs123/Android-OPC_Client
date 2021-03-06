/* ========================================================================
 * Copyright (c) 2005-2013 The OPC Foundation, Inc. All rights reserved.
 *
 * OPC Foundation MIT License 1.00
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * The complete license agreement can be found here:
 * http://opcfoundation.org/License/MIT/1.00/
 * ======================================================================*/

package org.opcfoundation.ua.core;

import org.opcfoundation.ua.builtintypes.ServiceResult;
import org.opcfoundation.ua.builtintypes.StatusCode;
import org.opcfoundation.ua.builtintypes.Structure;
import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.UnsignedByte;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.core.Attributes;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import org.opcfoundation.ua.builtintypes.LocalizedText;
import org.opcfoundation.ua.builtintypes.QualifiedName;
import org.opcfoundation.ua.builtintypes.UnsignedByte;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.core.InstanceNode;
import org.opcfoundation.ua.core.NodeClass;
import org.opcfoundation.ua.core.ReferenceNode;



public class ObjectNode extends InstanceNode implements Structure, Cloneable {
	
	public static final NodeId ID = Identifiers.ObjectNode;
	public static final NodeId BINARY = Identifiers.ObjectNode_Encoding_DefaultBinary;
	public static final NodeId XML = Identifiers.ObjectNode_Encoding_DefaultXml;	
	
    protected UnsignedByte EventNotifier;
    
    public ObjectNode() {}
    
    public ObjectNode(NodeId NodeId, NodeClass NodeClass, QualifiedName BrowseName, LocalizedText DisplayName, LocalizedText Description, UnsignedInteger WriteMask, UnsignedInteger UserWriteMask, ReferenceNode[] References, UnsignedByte EventNotifier)
    {
        super(NodeId, NodeClass, BrowseName, DisplayName, Description, WriteMask, UserWriteMask, References);
        this.EventNotifier = EventNotifier;
    }
    
    public UnsignedByte getEventNotifier()
    {
        return EventNotifier;
    }
    
    public void setEventNotifier(UnsignedByte EventNotifier)
    {
        this.EventNotifier = EventNotifier;
    }
    
    /**
      * Deep clone
      *
      * @return cloned ObjectNode
      */
    public ObjectNode clone()
    {
        ObjectNode result = new ObjectNode();
        result.NodeId = NodeId;
        result.NodeClass = NodeClass;
        result.BrowseName = BrowseName;
        result.DisplayName = DisplayName;
        result.Description = Description;
        result.WriteMask = WriteMask;
        result.UserWriteMask = UserWriteMask;
        if (References!=null) {
            result.References = new ReferenceNode[References.length];
            for (int i=0; i<References.length; i++)
                result.References[i] = References[i].clone();
        }
        result.EventNotifier = EventNotifier;
        return result;
    }
    
 

	public boolean supportsAttribute(UnsignedInteger attributeId) {
    	
    	if (attributeId.equals(Attributes.EventNotifier)) {    			
    			return true;
    	}
    		
    	return super.supportsAttribute(attributeId);
    }
 
 	public org.opcfoundation.ua.builtintypes.Variant read(UnsignedInteger attributeId) {
 		if (attributeId.equals(Attributes.EventNotifier))                return new org.opcfoundation.ua.builtintypes.Variant(EventNotifier);
 		return super.read(attributeId);
 	}
 
 	public ServiceResult write(UnsignedInteger attributeId, Object value){
	 	if (attributeId.equals(Attributes.EventNotifier)) {
	 		EventNotifier = (UnsignedByte) value;
	 		return new ServiceResult(StatusCode.GOOD);
	 	}
	 	
	 	return super.write(attributeId, value);
	 }
 
	public NodeId getTypeId() {
		return ID;
	}

	public NodeId getXmlEncodeId() {
		return XML;
	}

	public NodeId getBinaryEncodeId() {
		return BINARY;
	}
	
	public String toString() {
		return "ObjectNode: "+ObjectUtils.printFieldsDeep(this);
	}

}
