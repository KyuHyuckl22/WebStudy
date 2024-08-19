package com.sist.vo;

import java.util.Date;

import lombok.Data;

/*

앨범스토어       album_store

ANO			NUMBER						앨범번호
APHOTO		VARCHAR2(2000 BYTE)			앨범사진
ANAME			VARCHAR2(2000 BYTE)			앨범이름
AARTIST			VARCHAR2(2000 BYTE)			아티스트
ARDATE			DATE							발매일
ARATING		NUMBER						별점
APRICE			VARCHAR2(2000 BYTE)			앨범가격
ADIS			VARCHAR2(2000 BYTE)			할인율
ADISPRICE		VARCHAR2(2000 BYTE)			할인가격
ADETAIL		VARCHAR2(4000 BYTE)			앨범속성
AIMG			VARCHAR2(4000 BYTE)			앨범이미지

 */
@Data
public class AlbumVO {
	private int ano;
	private String ardate,aphoto,aname,aartist,aprice,adisprice,adetail,aimg;

}
