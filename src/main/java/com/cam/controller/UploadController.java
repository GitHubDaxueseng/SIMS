package com.cam.controller;

import com.blade.mvc.Const;
import com.blade.mvc.annotation.*;
import com.blade.mvc.multipart.FileItem;
import com.blade.mvc.ui.RestResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path
public class UploadController {

	@GetRoute("uploadLink")
	public String index() {
		return "upload.html";
	}

	@PostRoute("upload")
	@JSON
	public RestResponse doUpload(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			// Save the temporary file to the specified path
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/upload/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}

	@GetRoute("word")
	public String toWord() {
		return "word.html";
	}

	@PostRoute("word")
	@JSON
	public RestResponse doUploadWord(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/Word/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}

	@GetRoute("pdf")
	public String toPdf() {
		return "pdf.html";
	}

	@PostRoute("pdf")
	@JSON
	public RestResponse doUploadPdf(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/Pdf/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}

	@GetRoute("excel")
	public String toExcel() {
		return "excel.html";
	}

	@PostRoute("excel")
	@JSON
	public RestResponse doUploadExcel(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/Excel/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}

	@GetRoute("video")
	public String toVideo() {
		return "video.html";
	}

	@PostRoute("video")
	@JSON
	public RestResponse doUploadVideo(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/Video/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}

	@GetRoute("other")
	public String toOther() {
		return "other.html";
	}

	@PostRoute("other")
	@JSON
	public RestResponse doUploadOther(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			try {
				Files.write(Paths.get(Const.CLASSPATH + "/upload/" + fileItem.getFileName()), data);
				return RestResponse.ok();
			} catch (IOException e) {
				e.printStackTrace();
				return RestResponse.fail(e.getMessage());
			}
		}
		return RestResponse.ok();
	}
}
