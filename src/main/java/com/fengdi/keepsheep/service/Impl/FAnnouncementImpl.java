package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FAnnouncementExample;
import com.fengdi.keepsheep.mapper.FAnnouncementMapper;
import com.fengdi.keepsheep.service.FAnnouncementService;
import com.fengdi.keepsheep.util.Random2Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

	@Override
	public FAnnouncement selectByPrimaryKey(String announcementNo) {
		return fannouncementMapper.selectByPrimaryKey(announcementNo);
	}

	@Override
	public int deleteByPrimaryKey(String announcementNo) {
		return fannouncementMapper.deleteByPrimaryKey(announcementNo);
	}

	@Override
	public int updateByPrimaryKeySelective(FAnnouncement record) {
		return fannouncementMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updatestauts(String announcementNo, String status) {
		return fannouncementMapper.updatestauts(announcementNo,status);
	}

	@Override
	public int countByExample() {
		return fannouncementMapper.countByExample(new FAnnouncementExample());
	}

	@Override
	public List<FAnnouncement> selectByMhcx(String announcementName) {
		return fannouncementMapper.selectByMhcx(announcementName);
	}

	@Override
	public List<FAnnouncement> selectStauts(String status) {
		return fannouncementMapper.selectStauts(status);
	}

	@Override
	public List<FAnnouncement> selectByYes() {
		return fannouncementMapper.selectByYes();
	}


}
