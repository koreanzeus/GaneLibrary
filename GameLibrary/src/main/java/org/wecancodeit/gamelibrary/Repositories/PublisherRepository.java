package org.wecancodeit.gamelibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.gamelibrary.Models.PublisherModel;

public interface PublisherRepository extends JpaRepository<PublisherModel, Long> {
    PublisherModel findByName(String name);
}
