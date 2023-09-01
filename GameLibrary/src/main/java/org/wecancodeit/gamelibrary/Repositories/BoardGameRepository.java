package org.wecancodeit.gamelibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.gamelibrary.Models.BoardGameModel;

public interface BoardGameRepository extends JpaRepository<BoardGameModel, Long> {
    BoardGameModel findByName(String name);
}
