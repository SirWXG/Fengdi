package com.fengdi.keepsheep.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FAnnouncementExample;
import com.fengdi.keepsheep.mapper.FAnnouncementMapper;
import org.springframework.stereotype.Service;

import com.fengdi.keepsheep.util.Random2Utils;
import com.fengdi.keepsheep.service.FAnnouncementService;

@Service
public class FAnnouncementImpl implements FAnnouncementService {
	
	@Resource
	private FAnnouncementMapper fannouncementMapper;

	@Override
	public List<FAnnouncement> selectByExample() {
		return fannouncementMapper.selectByExample(new FAnnouncementExample());
	}

	@Override
	public int insert(FAnnouncement record) {
		record.setAnnouncementNo(Random2Utils.buildSn("SHP"));
		return fannouncementMapper.insert(record);
	}
	
	
}
