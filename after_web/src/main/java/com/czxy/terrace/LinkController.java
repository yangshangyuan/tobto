package com.czxy.terrace;

import com.czxy.terrace.service.LinkService;
import com.czxy.tobto.domain.TFinds;
import com.czxy.utils.vo.DataGridResultInfo;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Resource
    private LinkService linkService;

    @GetMapping("/findAllTFinds")
    public ResponseEntity<DataGridResultInfo> findAll(String fName,Integer page, Integer rows){

        DataGridResultInfo allTFinds = linkService.findAllTFinds(fName,page,rows);

        return new ResponseEntity<>(allTFinds, HttpStatus.OK);
    }

    @PostMapping("/addTFinds")
    public ResponseEntity<Void> addLink(TFinds tFinds){
        System.out.println(tFinds);
        int count = linkService.addLink(tFinds);
        if (count == 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updataTFinds")
    public ResponseEntity<Void> update(TFinds tFinds) {
        try {
          System.out.println(tFinds+"这是controller的");
            linkService.update(tFinds);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteTFinds/{fId}")
    public ResponseEntity<Void> delted(@PathVariable("fId") String fId) {
        System.out.println(fId);
        try {
            String[] split = fId.split(",");
            for (String idd : split) {
                int i = Integer.parseInt(idd);
                linkService.deleted(i);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
