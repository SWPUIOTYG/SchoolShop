package com.swpu.uchain.demo.service.Impl;

import com.swpu.uchain.demo.dao.HeadLineMapper;
import com.swpu.uchain.demo.entity.HeadLine;
import com.swpu.uchain.demo.form.HeadLineForm;
import com.swpu.uchain.demo.service.HeadLineService;
import com.swpu.uchain.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@Slf4j
public class HeadLineServiceImpl implements HeadLineService {

    @Value("{file.upload_dir}")
    private String path;

    @Autowired
    private HeadLineMapper headLineMapper;

    @Override
    public boolean insert(HeadLine headLine) {
        return headLineMapper.insert(headLine)==1;
    }

    @Override
    public boolean update(HeadLine headLine) {
        return headLineMapper.updateByPrimaryKey(headLine)==1;
    }

    @Override
    public boolean delete(Integer lineId) {
        return headLineMapper.deleteByPrimaryKey(lineId)==1;
    }

    @Override
    public ResultVO insertHeadLine(HeadLineForm headLineForm, MultipartFile file) {
        return null;
    }

    @Override
    public ResultVO deleteHeadLine(Integer LineId) {
        return null;
    }

    @Override
    public ResultVO updateHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public ResultVO selectAllHeadLine() {
        return null;
    }
}
