
-- 작성자
CREATE TABLE author_tb (
	author_id VARCHAR(30) PRIMARY KEY, -- 작성자ID
	author_nm VARCHAR(50) NOT NULL, -- 작성자명
	email     VARCHAR(50) NULL,     -- 이메일
	password  VARCHAR(50) NOT NULL  -- 비밀번호
);

-- 블로그
CREATE TABLE blog_tb (
	blog_id   INTEGER      PRIMARY KEY AUTO_INCREMENT, -- 블로그ID
	blog_nm   VARCHAR(200) NOT NULL, -- 블로그명
	author_id VARCHAR(30)  NOT NULL  -- 작성자ID
);

-- 포스트
CREATE TABLE post_tb (
	post_id  INTEGER       PRIMARY KEY AUTO_INCREMENT, -- 포스트ID
	subject  VARCHAR(300)  NOT NULL, -- 제목
	contents VARCHAR(1000) NOT NULL, -- 내용
	post_type CHAR(1)      NOT NULL, -- 포스트유형
	blog_id  INTEGER       NOT NULL  -- 블로그ID
);

-- 코멘트
CREATE TABLE comment_tb (
	comment_id INTEGER      PRIMARY KEY AUTO_INCREMENT, -- 코멘트ID
	comment    VARCHAR(300) NOT NULL, -- 코멘트내용
	author_id  VARCHAR(30)  NULL,     -- 작성자ID
	post_id    INTEGER      NOT NULL  -- 포스트ID
);
