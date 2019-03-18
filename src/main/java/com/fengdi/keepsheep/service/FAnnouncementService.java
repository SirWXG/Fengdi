package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAnnouncement;

import java.util.List;

public interface FAnnouncementService {
	
	List<FAnnouncement> selectByExample();
	
	int insert(FAnnouncement record);

    FAnnouncement selectByPrimaryKey(String announcementNo);

	int deleteByPrimaryKey(String announcementNo);

	int updateByPrimaryKeySelective(FAnnouncement record);

	int updatestauts(String announcementNo,String status);

	int countByExample();

	List<FAnnouncement> selectByMhcx(String announcementName);

	List<FAnnouncement> selectStauts(String status);

	List<FAnnouncement> selectByYes();
}
