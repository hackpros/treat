/**
 * 
 */
package com.navigate.treat.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author luohai.hjf
 *
 */
public abstract class BaseDO {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
