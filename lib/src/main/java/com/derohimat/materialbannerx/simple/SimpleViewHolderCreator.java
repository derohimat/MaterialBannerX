package com.derohimat.materialbannerx.simple;

import com.derohimat.materialbannerx.holder.ViewHolderCreator;

/**
 * @author Jack Fu <rtugeek@gmail.com>
 * @date 2018/06/08
 */
public class SimpleViewHolderCreator implements ViewHolderCreator {

    @Override
    public SimpleHolder createHolder() {
        return new SimpleHolder();
    }

}
