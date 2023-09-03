package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
/**
 * 老年人回忆
 */
@TableName("memory")
public class MemoryEntity implements Serializable{

        private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        private Long id;

        /**
         * 回忆标题
         */
        private String memoryTitle;

        /**
         * 回忆视频
         */
        private String video ;

        /**
         * 回忆图片
         */
        private String image;

        /**
         * 回忆音频
         */

        private String audio;

        /**
         * 回忆详情
         */

        private String text;

        /**
         * 回忆所在位置
         */

        private String location;

        /**
         * 回忆时间
         */
        private Date addTime;

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMemoryTitle() {
            return memoryTitle;
        }

        public void setMemoryTitle(String memoryTitle) {
            this.memoryTitle = memoryTitle;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Date getAddTime() {
            return addTime;
        }

        public void setAddTime(Date addTime) {
            this.addTime = addTime;
        }
}
