package elder.memory.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 老年人回忆
 */
@TableName("memory")
@Data
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

        /**
         * 标签id
         */
        private Long tagId;

}
