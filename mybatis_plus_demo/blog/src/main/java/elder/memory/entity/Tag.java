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
@TableName("tag")
@Data
public class Tag implements Serializable{

        private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        private Long id;

        /**
         * 标签名称
         */
        private String name;


}
