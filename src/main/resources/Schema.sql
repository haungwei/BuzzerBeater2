CREATE TABLE Season         --賽季
(
    seasonID                int not null,                   --賽季ID
    seasonName              nvarchar(20),                   --賽季名稱
    seasonBeginDate         datetime,                       --賽季開始時間
    seasonEndDate           datetime,                       --賽季結束時間
    signUpBegin             datetime,                       --報名開始時間
    signUpEnd               datetime,                       --報名截止時間
    descriptions            nvarchar(max),                  --備註
);
CREATE SEQUENCE seq_season MINVALUE 1001 START WITH 1001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Groups         --分組
(
    groupID                 int not null,                                 --分組ID
    seasonID                int references Season(seasonID),              --季賽ID
    groupName               nvarchar(20),                                 --分組名稱
    maxTeams                int,                                          --球隊數量上限
    minTeams                int,                                          --球隊數量下限
    currentTeams            int,                                          --目前球隊數量
    maxPlayers              int,                                          --球隊成員上限
    minPlayers              int,                                          --球隊成員下限
);
CREATE SEQUENCE seq_groups MINVALUE 2001 START WITH 2001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Players        --球員
(
    playerID                int not null,                   --球員ID
    playerName              nvarchar(20),                   --球員姓名
    id                      varchar(20),                    --身分證字號
    height                  float,                          --身高
    weights                 float,                          --體重
    birthday                date,                           --生日
    nationality             varchar(30),                    --國籍
    photo                   varchar2(max)                   --照片
);

CREATE SEQUENCE seq_players MINVALUE 70001 START WITH 70001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE LocationInfo     --場地資訊
(
    locationID              int not null,                   --場地ID
    locationName            nvarchar(20),                   --場地名稱
    locationAddr            nvarchar(50),                   --地址
    locationMark            nvarchar(500),                  --Mark(for googleMap)
    locationPhoto           varchar2(max)                   --場地圖片
);
CREATE SEQUENCE seq_locationInfo MINVALUE 101 START WITH 101 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
 CREATE TABLE Teams         --球隊
(
    teamID                  int not null,                           --球隊ID
    captainID               int references Players(playerID),       --隊長ID
    captainEmail            varchar2(50),                            --隊長Email
    captainPhone            varchar2(50),                            --隊長連絡電話
    locationID              int,                                    --主場ID
    teamName                nvarchar2(50),                           --球隊名稱
    coachName               nvarchar2(50),                           --總教練
    bossName                nvarchar2(50),                           --老闆
    teamBadge               varchar2(max),                          --隊徽
    totalWin                int,                                    --總勝場數
    totalLose               int,                                    --總敗場數
    winRate                 float,                                  --勝率
    remarks                 nvarchar(200),                          --備註
);
CREATE SEQUENCE seq_teams MINVALUE 3001 START WITH 3001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE Games          --賽事
(
    gameID                  int not null,                                   --賽事ID
    groupID                 int references Groups(groupID),                 --分組ID
    locationID              int references LocationInfo(locationID),        --比賽地點
    teamAID                 int references Teams(teamID),                   --A隊ID
    teamAScore              int,                                            --A隊得分
    teamBID                 int references Teams(teamID),                   --B隊ID
    teamBScore              int,                                            --B隊得分
    winnerID                int,                                            --獲勝隊伍ID
    gameBeginDate           timestamp,                                      --賽事開始時間
    gameEndDate             datetime,                                       --賽事結束時間
);
CREATE SEQUENCE seq_games MINVALUE 4001 START WITH 4001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE GroupRegistration                    --分組報名表
(
    teamID                  int references Teams(teamID),               --球隊ID
    groupID                 int references Groups(groupID),             --分組ID
    teamStat                int,                                        --球隊報名狀態
    registerDate            datetime,                                   --球隊報名時間
    paymentNumber           char(5),                                    --繳費後五碼

    CONSTRAINT group_reg_pk PRIMARY KEY (teamID, groupID)
);

--------------------------------------------------------------------------------------------------------------
CREATE TABLE TeamComposition        --球隊構成表
(
    teamID                  int references Teams(teamID),           --球隊ID
    playerID                int references Players(playerID),       --球員ID
    playerNo                tinyint,                                --背號
    playerRole              varchar(2),                             --位置
    joinTeamDate            datetime,                               --加入球隊時間
    leaveTeamDate           datetime,                               --離開球隊時間

    CONSTRAINT team_composition_pk PRIMARY KEY (teamID, playerID)
);

--------------------------------------------------------------------------------------------------------------
create table PersonalData    --個人比賽數據
( 
    playerID                int references Players(playerID),       --球員ID
    gameID                  int references Games(gameID),           --賽事ID
    teamID                  int references Teams(teamID),           --球隊ID
    gameTime			    int,                                    --出場時間 (單位: 秒)
    twoPoint                INT,                                    --兩分命中數
    twoPointShot            INT,                                    --兩分出手數
    threePoint              INT,                                    --三分命中數
    threePointShot          INT,                                    --三分出手數
    fg                      INT,                                    --罰球命中數
    fgShot                  INT,                                    --罰球出手數
    offReb                  INT,                                    --進攻籃板
    defReb                  INT,                                    --防守籃板
    assist                  INT,                                    --助攻
    steal                   INT,                                    --抄截
    blocks                  INT,                                    --阻攻
    turnover                INT,                                    --失誤
    personalFouls           INT,                                    --犯規
    points			        INT,                                    --得分
    startingPlayer          INT,                                    --是否先發

    CONSTRAINT personal_data_pk PRIMARY KEY (playerID, gameID)
);

--------------------------------------------------------------------------------------------------------------
CREATE TABLE GameMedia    --賽事影音
(
    mediaID                 int not null,                           --影音編號
    gameID					int references Games(gameID),           --賽事ID
    mediasName              nvarchar(20),                           --影音名稱
    gameVideo			    varchar(200),                           --賽事影片(連結)
    gamePhoto			    varchar2(max),                          --賽事照片
    mediaType               varchar(10),                            --檔案類型
    mediaDate               datetime,                               --日期
    descriptions            nvarchar(200),                          --描述
    tag                     nvarchar(200),                          --Tag
);
CREATE SEQUENCE seq_gameMedia MINVALUE 6001 START WITH 6001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE MemberInfo         --會員資料
(
    memberID                int not null,                               --會員ID
    acc                     varchar2(50),                               --帳號(Gmail)
    name                    varchar2(50),                               --名稱
    auth                    varchar2(50),                               --權限
    registerTime            datetime,                                   --註冊時間
    teamID                  int,                                        --球隊ID
);
CREATE SEQUENCE seq_memberInfo MINVALUE 8001 START WITH 8001 INCREMENT BY 1 CACHE 10;

--------------------------------------------------------------------------------------------------------------
CREATE TABLE PlayerGroups      --球員分組表
(
    groupID                 int references Groups(groupID),	            --分組ID
    playerID                int references Players(playerID),           --球員ID

    CONSTRAINT player_groups_pk PRIMARY KEY (groupID, playerID)
);


--------------------------------------------------------------------------------------------------------------
create table TeamStat      --分組狀態表
(
    teamStatID              int primary key,	        --分組ID
    teamStatus              nvarchar2(50),              --分組狀態
);

--------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------

