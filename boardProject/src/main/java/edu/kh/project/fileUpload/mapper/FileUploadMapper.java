package edu.kh.project.fileUpload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.fileUpload.dto.FileDto;

@Mapper
public interface FileUploadMapper {

	
	/**
	 * 단일 파일 정보 DB에 삽입
	 * @param file
	 * @return result
	 */
	int fileInsert(FileDto file);

	/** 파일 업로드
	 * @return filelist
	 */
	List<FileDto> selectFileList();

}
