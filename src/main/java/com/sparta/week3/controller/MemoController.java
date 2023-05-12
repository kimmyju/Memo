package com.sparta.week3.controller;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.domain.MemoRepository;
import com.sparta.week3.domain.MemoRequestDto;
import com.sparta.week3.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor //알아서 생성자 다 넣어주는 녀석
@RestController // 객체 생성을 다 알아서 해줌
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //생성부분
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) //@RequestBody --> 클라이언트가 어떤 content를 보내면 바오 받아서 저 requestDto에 넣어달라는 의미
    {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    //조회부분
    @GetMapping("/api/memos")
    public List<Memo> readMemo()
    {
        LocalDateTime start = LocalDateTime.now().minusHours(24);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id)
    {
        memoRepository.deleteById(id);
        return id;

    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }



}
