package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAnnouncement;

import java.util.List;

public interface FAnnouncementService {
	
	List<FAnnouncement> selectByExample();
	
	int insert(FAnnouncement record);
}
