package com.swpu.uchain.demo.service;

import com.swpu.uchain.demo.entity.HeadLine;
import com.swpu.uchain.demo.form.HeadLineForm;
import com.swpu.uchain.demo.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface HeadLineService {

    boolean insert(HeadLine headLine);

    boolean update(HeadLine headLine);

    boolean delete(Integer lineId);

    ResultVO insertHeadLine(HeadLineForm headLineForm, MultipartFile file);

    ResultVO deleteHeadLine(Integer LineId);

    ResultVO updateHeadLine(HeadLine headLine);

    ResultVO selectAllHeadLine();

}
