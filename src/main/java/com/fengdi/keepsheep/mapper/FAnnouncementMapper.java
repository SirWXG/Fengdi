package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FAnnouncementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAnnouncementMapper {
    int countByExample(FAnnouncementExample example);

    int deleteByExample(FAnnouncementExample example);

    int deleteByPrimaryKey(String announcementNo);

    int insert(FAnnouncement record);

    int insertSelective(FAnnouncement record);

    List<FAnnouncement> selectByExample(FAnnouncementExample example);

    FAnnouncement selectByPrimaryKey(String announcementNo);

    int updateByExampleSelective(@Param("record") FAnnouncement record, @Param("example") FAnnouncementExample example);

    int updateByExample(@Param("record") FAnnouncement record, @Param("example") FAnnouncementExample example);

    int updateByPrimaryKeySelective(FAnnouncement record);

    int updateByPrimaryKey(FAnnouncement record);

    int updatestauts(@Param("announcementNo")String announcementNo,@Param("status")String status);

    List<FAnnouncement> selectByMhcx(String announcementName);
}