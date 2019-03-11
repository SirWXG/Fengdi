package com.fengdi.keepsheep.service;

import java.util.List;

import com.fengdi.keepsheep.bean.FAnnouncement;

public interface FAnnouncementService {
	
	List<FAnnouncement> selectByExample();
	
	int insert(FAnnouncement record);
}
