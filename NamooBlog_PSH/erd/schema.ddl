-- 작성자
DROP TABLE IF EXISTS author_tb RESTRICT;

-- 블로그
DROP TABLE IF EXISTS blog_tb RESTRICT;

-- 포스트
DROP TABLE IF EXISTS post_tb RESTRICT;

-- 코멘트
DROP TABLE IF EXISTS comment_tb RESTRICT;

-- 작성자
CREATE TABLE author_tb (
	author_id VARCHAR(30) NOT NULL, -- 작성자ID
	author_nm VARCHAR(50) NOT NULL, -- 작성자명
	email     VARCHAR(50) NULL,     -- 이메일
	password  VARCHAR(50) NOT NULL  -- 비밀번호
);

-- 작성자
ALTER TABLE author_tb
	ADD CONSTRAINT PK_author_tb -- 작성자 기본키
		PRIMARY KEY (
			author_id -- 작성자ID
		);

-- 블로그
CREATE TABLE blog_tb (
	blog_id   INTEGER      NOT NULL, -- 블로그ID
	blog_nm   VARCHAR(200) NOT NULL, -- 블로그명
	author_id VARCHAR(30)  NULL      -- 작성자ID
);

-- 블로그
ALTER TABLE blog_tb
	ADD CONSTRAINT PK_blog_tb -- 블로그 기본키
		PRIMARY KEY (
			blog_id -- 블로그ID
		);

ALTER TABLE blog_tb
	MODIFY COLUMN blog_id INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE blog_tb
	AUTO_INCREMENT = 1;

-- 포스트
CREATE TABLE post_tb (
	post_id   INTEGER       NOT NULL, -- 포스트ID
	subject   VARCHAR(300)  NOT NULL, -- 제목
	contents  VARCHAR(1000) NOT NULL, -- 내용
	post_type CHAR(1)       NOT NULL, -- 포스트타입
	blog_id   INTEGER       NOT NULL  -- 블로그ID
	
);

-- 포스트
ALTER TABLE post_tb
	ADD CONSTRAINT PK_post_tb -- 포스트 기본키
		PRIMARY KEY (
			post_id -- 포스트ID
		);

ALTER TABLE post_tb
	MODIFY COLUMN post_id INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE post_tb
	AUTO_INCREMENT = 1;

-- 코멘트
CREATE TABLE comment_tb (
	comment_id INTEGER      NOT NULL, -- 코멘트ID
	comment    VARCHAR(300) NOT NULL, -- 코멘트내용
	post_id    INTEGER      NULL,     -- 포스트ID
	author_id  VARCHAR(30)  NOT NULL  -- 작성자ID
);

-- 코멘트
ALTER TABLE comment_tb
	ADD CONSTRAINT PK_comment_tb -- 코멘트 기본키
		PRIMARY KEY (
			comment_id -- 코멘트ID
		);

ALTER TABLE comment_tb
	MODIFY COLUMN comment_id INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE comment_tb
	AUTO_INCREMENT = 1;