/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/8/31 16:28:23                           */
/*==============================================================*/


drop table if exists CommentReply;

drop table if exists "Like";

drop table if exists Memory;

drop table if exists MemoryComment;

drop table if exists MemoryList;

drop table if exists User;

/*==============================================================*/
/* Table: CommentReply                                          */
/*==============================================================*/
create table CommentReply
(
   replyId              bigint not null,
   memoryId             bigint,
   commentId            bigint,
   userId               bigint,
   replyUserId          bigint,
   replyContent         text,
   replyTime            date,
   primary key (replyId)
);

/*==============================================================*/
/* Table: "Like"                                                */
/*==============================================================*/
create table "Like"
(
   LikeId               bigint not null,
   userId               bigint,
   memoryId             bigint,
   likeTime             date,
   primary key (LikeId)
);

/*==============================================================*/
/* Table: Memory                                                */
/*==============================================================*/
create table Memory
(
   memoryId             bigint not null,
   memoryTitle          varchar(200),
   video                varchar(200),
   image                varchar(200),
   audio                varchar(200),
   text                 text,
   location             varchar(200),
   addTime              date,
   userId               bigint,
   primary key (memoryId)
);

/*==============================================================*/
/* Table: MemoryComment                                         */
/*==============================================================*/
create table MemoryComment
(
   commentId            bigint not null,
   userId               bigint,
   commentContent       text,
   commentTime          date,
   memoryId             bigint,
   primary key (commentId)
);

/*==============================================================*/
/* Table: MemoryList                                            */
/*==============================================================*/
create table MemoryList
(
   memoryListId         bigint not null,
   userId               bigint,
   memorys              varchar(1000),
   primary key (memoryListId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   userId               bigint not null,
   username             varchar(50),
   password             varchar(50),
   realname             varchar(20),
   age                  int,
   birth                date,
   primary key (userId)
);

alter table CommentReply add constraint FK_Reference_5 foreign key (memoryId)
      references Memory (memoryId) on delete restrict on update restrict;

alter table CommentReply add constraint FK_Reference_6 foreign key (commentId)
      references MemoryComment (commentId) on delete restrict on update restrict;

alter table CommentReply add constraint FK_Reference_7 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table "Like" add constraint FK_Reference_8 foreign key (memoryId)
      references Memory (memoryId) on delete restrict on update restrict;

alter table "Like" add constraint FK_Reference_9 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Memory add constraint FK_Reference_1 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table MemoryComment add constraint FK_Reference_3 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table MemoryComment add constraint FK_Reference_4 foreign key (memoryId)
      references Memory (memoryId) on delete restrict on update restrict;

alter table MemoryList add constraint FK_Reference_2 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

