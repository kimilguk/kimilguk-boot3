package com.herokuapp.kimilgukboot2.service.posts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.kimilgukboot2.domain.posts.Posts;
import com.herokuapp.kimilgukboot2.domain.posts.PostsRepository;
import com.herokuapp.kimilgukboot2.web.dto.PostsDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor//final 매개변수가 있는 생성자메소드가 자동 생성된다
@Service//서비스 객체로 만든다
public class PostsService {
	//로그 출력 객체생성
	private Logger logger = LoggerFactory.getLogger(getClass());
	private final PostsRepository postsRepository;
	
	@Transactional//저장:Create
	public Long save(PostsDto requestDto) {
		return postsRepository.save(requestDto.toEntity())
				.getId();//DB에저장 후 추가된 Id값을 반환한다.
	}
	@Transactional//읽기:1개게시물 Read
	public PostsDto postsOne(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException(id + " 번째 게시글이 없습니다."));
		return new PostsDto(entity);
	}
	@Transactional//읽기:전체게시물 Read
	public Page<Posts> postsList(Pageable pageable) {
		Page<Posts> postsList = postsRepository.findAll(pageable);
		return postsList;
	}
	@Transactional//수정:Update는 엔티티의 값만수정하면 레포지토리 없이 DB값도 연동된다
	public Long update(Long id, PostsDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException(id + " 번째 게시글이 없습니다."));//에러발생시 콘솔창에 에러 표시 후 메소드 종료됨. 자바8부터 람다=애러우 메소드 사용가능
		posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getFileId());//빌더형식이 아니기 때문에 위치를 잘 확인해야 한다.
		return id;
	}
	@Transactional//삭제:Delete
	public void delete(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException(id + " 번째 게시글이 없습니다."));
		postsRepository.delete(entity);
	}
}
