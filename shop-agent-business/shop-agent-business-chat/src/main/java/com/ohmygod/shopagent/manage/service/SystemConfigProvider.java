package com.ohmygod.shopagent.manage.service;

import com.ohmygod.shopagent.manage.model.SystemConfigSnapshot;

public interface SystemConfigProvider {

    SystemConfigSnapshot currentSnapshot();

    default void invalidate(){}

}
