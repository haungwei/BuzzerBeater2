-- H2 database 無法使用 trigger

CREATE TABLE Seasons         --賽季
(
    season_id               int not null,                   --賽季ID
    season_name             nvarchar(20),                   --賽季名稱
    begin_date              datetime,                       --賽季開始時間
    end_date                datetime,                       --賽季結束時間
    register_begin_date     datetime,                       --報名開始時間
    register_end_date       datetime,                       --報名截止時間
    descriptions            nvarchar(max),                  --備註
);
CREATE SEQUENCE seq_seasons MINVALUE 1001 START WITH 1001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Groups         --分組
(
    group_id                int not null,                               --分組ID
    season_id               int references Seasons(season_id),           --季賽ID
    group_name              nvarchar(20),                               --分組名稱
    max_teams               int,                                        --球隊數量上限
    min_teams               int,                                        --球隊數量下限
    current_teams           int,                                        --目前球隊數量
    max_players             int,                                        --球隊成員上限
    min_players             int,                                        --球隊成員下限
);
CREATE SEQUENCE seq_groups MINVALUE 2001 START WITH 2001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Players        --球員
(
    player_id               int not null,                   --球員ID
    player_name             nvarchar(20),                   --球員姓名
    id_card_number          varchar(20),                    --身分證字號
    height                  float,                          --身高
    weights                 float,                          --體重
    birthday                date,                           --生日
    nationality             varchar(30),                    --國籍
    photo                   varchar(max),                   --照片
);

CREATE SEQUENCE seq_players MINVALUE 70001 START WITH 70001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE LocationInfo     --場地資訊
(
    location_id             int not null,                   --場地ID
    location_name           nvarchar(20),                   --場地名稱
    address                 nvarchar(50),                   --地址
    mark                    nvarchar(500),                  --Mark(for googleMap)
    photo                   varchar(max),                   --場地圖片
);
CREATE SEQUENCE seq_locationInfo MINVALUE 101 START WITH 101 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
 CREATE TABLE Teams         --球隊
(
    team_id                 int not null,                           --球隊ID
    captain_id              int references Players(player_id),      --隊長ID
    captain_email           varchar(50),                            --隊長Email
    captain_phone           varchar(50),                            --隊長連絡電話
    location_id             int,                                    --主場ID
    team_name               nvarchar(50),                           --球隊名稱
    coach_name              nvarchar(50),                           --總教練
    boss_name               nvarchar(50),                           --老闆
    team_badge              varchar(max),                           --隊徽
    total_win               int,                                    --總勝場數
    total_lose              int,                                    --總敗場數
    win_rate                float,                                  --勝率
    remarks                 nvarchar(200),                          --備註
);
CREATE SEQUENCE seq_teams MINVALUE 3001 START WITH 3001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Games          --賽事
(
    game_id                 int not null,                                   --賽事ID
    group_id                int references Groups(group_id),                 --分組ID
    location_id             int references LocationInfo(location_id),        --比賽地點
    team_a_id               int references Teams(team_id),                   --A隊ID
    team_a_score            int,                                            --A隊得分
    team_b_id               int references Teams(team_id),                   --B隊ID
    team_b_score            int,                                            --B隊得分
    winner_id               int,                                            --獲勝隊伍ID
    begin_date              timestamp,                                      --賽事開始時間
    end_date                datetime,                                       --賽事結束時間
);
CREATE SEQUENCE seq_games MINVALUE 4001 START WITH 4001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Groups_Teams                    --分組報名表
(
    team_id                 int references Teams(team_id),              --球隊ID
    group_id                int references Groups(group_id),            --分組ID
    team_stat               int,                                        --球隊報名狀態
    register_date           datetime,                                   --球隊報名時間
    payment_number          char(5),                                    --繳費後五碼

    CONSTRAint group_reg_pk PRIMARY KEY (team_id, group_id)
);

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Teams_Players        --球隊構成表
(
    team_id                 int references Teams(team_id),           --球隊ID
    player_id               int references Players(player_id),       --球員ID
    player_number           tinyint,                                --背號
    player_role             varchar(2),                             --位置
    join_date               datetime,                               --加入球隊時間
    leave_date              datetime,                               --離開球隊時間

    CONSTRAint team_composition_pk PRIMARY KEY (team_id, player_id)
);

--------------------------------------------------------------------------------------------------------------
create table PersonalData    --個人比賽數據
( 
    player_id               int references Players(player_id),      --球員ID
    game_id                 int references Games(game_id),          --賽事ID
    team_id                 int references Teams(team_id),          --球隊ID
    game_time			    int,                                    --出場時間 (單位: 秒)
    two_point               int,                                    --兩分命中數
    two_point_shot          int,                                    --兩分出手數
    three_point             int,                                    --三分命中數
    three_point_shot        int,                                    --三分出手數
    fg                      int,                                    --罰球命中數
    fg_shot                 int,                                    --罰球出手數
    off_reb                 int,                                    --進攻籃板
    def_reb                 int,                                    --防守籃板
    assist                  int,                                    --助攻
    steal                   int,                                    --抄截
    blocks                  int,                                    --阻攻
    turnover                int,                                    --失誤
    personal_fouls          int,                                    --犯規
    points			        int,                                    --得分
    starting_player         int,                                    --是否先發

    CONSTRAint personal_data_pk PRIMARY KEY (player_id, game_id)
);

--------------------------------------------------------------------------------------------------------------
CREATE TABLE GameMedia    --賽事影音
(
    media_id                int not null,                           --影音編號
    game_id					int references Games(game_id),           --賽事ID
    medias_name             nvarchar(20),                           --影音名稱
    video			        varchar(200),                           --賽事影片(連結)
    photo			        varchar2(max),                          --賽事照片
    media_type              varchar(10),                            --檔案類型
    media_date              datetime,                               --日期
    descriptions            nvarchar(200),                          --描述
    tag                     nvarchar(200),                          --Tag
);
CREATE SEQUENCE seq_gameMedia MINVALUE 6001 START WITH 6001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE MemberInfo         --會員資料
(
    member_id               int not null,                           --會員ID
    account                 varchar(50),                            --帳號(Gmail)
    member_name             varchar(50),                            --名稱
    auth                    varchar(50),                            --權限
    register_time           datetime,                               --註冊時間
    team_id                 int,                                    --球隊ID
);
CREATE SEQUENCE seq_memberInfo MINVALUE 8001 START WITH 8001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Players_Groups      --球員分組表
(
    group_id                int references Groups(group_id),	    --分組ID
    player_id               int references Players(player_id),      --球員ID

    CONSTRAint player_groups_pk PRIMARY KEY (group_id, player_id)
);


--------------------------------------------------------------------------------------------------------------
create table TeamStat       --分組狀態表
(
    team_stat_id            int primary key,	        --分組ID
    team_status             nvarchar(50),               --分組狀態
);

--------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------

