package com.sparta.week3.service;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.domain.MemoRepository;
import com.sparta.week3.domain.MemoRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor//repository가 꼭 필요하다고 알려주는 애
@Service //service라고 알려주는 애
public class MemoService {

    private final MemoRepository memoRepository; //Memorepository는 memo 리스트를 전부다 찾는 녀석

    @Transactional//db에 꼭 업데이트를 해주어야해 라고 알려주는 어노테이션
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
